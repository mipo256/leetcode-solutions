class Solution {
    public String pushDominoes(String dominoes) {
        int rightestSlashIndex = -1;

        StringBuilder result = new StringBuilder(dominoes);

        for (int i =0; i < dominoes.length(); i++) {
            char s = dominoes.charAt(i);
            switch (s) {
                case 'R': {
                    if (rightestSlashIndex != -1) {
                        for (rightestSlashIndex += 1; rightestSlashIndex < i; rightestSlashIndex++) {
                            result.setCharAt(rightestSlashIndex, 'R');
                        }
                    }
                    rightestSlashIndex = i;
                    break;
                }
                case 'L' : {
                    if (rightestSlashIndex == -1) {
                        int j = i - 1;
                        while (j >= 0 && dominoes.charAt(j) != 'L') {
                            result.setCharAt(j, 'L');
                            j--;
                        }
                    } else {
                        int right = i - 1;
                        rightestSlashIndex += 1;

                        while (rightestSlashIndex < right) {
                            result.setCharAt(rightestSlashIndex, 'R');
                            result.setCharAt(right, 'L');
                            rightestSlashIndex++;
                            right--;
                        }

                        rightestSlashIndex = -1;
                    }
                }
            }
        }

        if (rightestSlashIndex != -1) {
            for (rightestSlashIndex += 1; rightestSlashIndex < result.length(); rightestSlashIndex++) {
                result.setCharAt(rightestSlashIndex, 'R');
            }
        }

        return result.toString();
    }
}
