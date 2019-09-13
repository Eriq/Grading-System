package studentgrades;

import ui.Welcome;

public class StudentGrades {

    public static int getSubjectCode (String sub) {
        if (sub.equals("Maths")) {
            return 1;
        } else if (sub.equals("English")) {
            return 2;
        }else if (sub.equals("Kiswahili")) {
            return 3;
        }else if (sub.equals("Chemistry")) {
            return 4;
        }else if (sub.equals("Physics")) {
            return 5;
        }else if (sub.equals("Biology")) {
            return 6;
        }else if (sub.equals("History")) {
            return 7;
        }else if (sub.equals("Geography")) {
            return 8;
        }else if (sub.equals("R.E")) {
            return 9;
        }else if (sub.equals("Computer")) {
            return 10;
        }else if (sub.equals("Business")) {
            return 11;
        }else if (sub.equals("Agriculture")) {
            return 12;
        }else if (sub.equals("German")) {
            return 13;
        } else if (sub.equals("French")) {
            return 14;
        } else {
            return 0;
        }
    }

    public static int getTermCode(String term) {
        if (term.equals("Term 1")) {
            return 1;
        }else if (term.equals("Term 2")) {
            return 2;
        } else if (term.equals("Term 3")) {
            return 3;
        } else {
            return 0;
        }
    }

    public static int getFormCode(String form) {
        if (form.equals("Form 1")) {
            return 1;
        }else if (form.equals("Form 2")) {
            return 2;
        } else if (form.equals("Form 3")) {
            return 3;
        } else if (form.equals("Form 4")) {
            return 4;
        } else {
            return 0;
        }
    }

    public static int getAverage(int opener, int midterm, int endterm) {
        double average = (0.2*opener) + (0.3*midterm) + (0.5*endterm);
        return (int)Math.round(average);
    }

    public static String getGrade(int mark) {
        if ( mark < 30) {
            return "E";
        } else  if (mark < 45) {
            return "D";
        } else if (mark < 55) {
            return "C";
        } else if (mark < 65) {
            return "B";
        } else {
            return "A";
        }
    }

    public static void main(String[] args) {
        Welcome welcome = new Welcome();
        welcome.setVisible(true);
        welcome.pack();
        welcome.setLocationRelativeTo(null);
        welcome.setDefaultCloseOperation(welcome.EXIT_ON_CLOSE);
    }
}
