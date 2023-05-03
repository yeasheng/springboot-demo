public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        Stack<Integer> stack = new Stack<>();
        // 将字符串转换为整型数组
        int[] digits = new int[inputString.length()];
        for (int i = 0; i < inputString.length(); i++) {
            // '0'对应的ASCII码为48，所以将字符数字转换为整数数字时，要减去48**
            digits[i] = inputString.charAt(i) - 48;
        }
        // 记录每个数字的次数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int digit : digits) {
            countMap.put(digit, countMap.getOrDefault(digit, 0) + 1);
        }
        HashMap<Integer, Integer> stackCountMap = new HashMap<>();
        for (int digit : digits) {
            countMap.put(digit, countMap.get(digit) - 1);
            if (stackCountMap.getOrDefault(digit, 0) == 2) {
                continue;
            }
            while (!stack.isEmpty() && digit > stack.peek()) {
                // 计算栈中保存的数字个数和剩余未push进栈中的数字个数之和
                int allCount = countMap.get(stack.peek()) + stackCountMap.getOrDefault(stack.peek(), 0);
                if (allCount <= 2) {
                    break;
                }
                // 后续还有相同的数字，且数字的总数大于2，弹出栈顶数字，因为越往后放，数值才会越小
                int pop = stack.pop();
                stackCountMap.put(pop, stackCountMap.get(pop) - 1);
            }
            stack.push(digit);
            stackCountMap.put(digit, stackCountMap.getOrDefault(digit,0) + 1);
        }
        StringBuilder sbd = new StringBuilder();
        while(!stack.isEmpty()) {
            sbd.append(stack.pop());
        }
        System.out.println(sbd.reverse().toString());
    }
