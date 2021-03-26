package ru.samsung.lesson12032021;

import java.util.Comparator;

public class UserYearComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        if (o1.getYear() > o2.getYear())
            return 1;
        else if (o1.getYear() < o2.getYear())
            return -1;
        else return 0;
    }
}
