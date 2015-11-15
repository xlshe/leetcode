public class LargestNumber {
    public String largestNumber(int[] num) {
        LinkedList<String> inputs = new LinkedList<>();
        for (int i : num) {
            inputs.add(String.valueOf(i));
        }
        Collections.sort(inputs, new SpecialComparitor());
        
        if (Integer.parseInt(inputs.peek()) == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String n : inputs) {
            sb.append(n);
        }
        return sb.toString();
    }
    
    private class SpecialComparitor implements Comparator<String> {
        @Override
        public int compare(String x, String y) {
            int total = x.length() * y.length();
            int xn = 0;
            int yn = 0;
            for (int i=0; i<total; i++) {
                if (x.charAt(xn) == y.charAt(yn)) {
                    xn = (xn + 1) % x.length();
                    yn = (yn + 1) % y.length();
                    continue;
                }
                return y.charAt(yn) - x.charAt(xn);
            }
            return 0;
        }
    }
}
