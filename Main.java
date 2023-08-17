import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;

public class Main {
    public static void main(String[] args) {
        welcomeMainMenu();
        Scanner iScanner = new Scanner(System.in, "cp866");
        HashSet<NoteBook> noteBooks = new HashSet<>();
        createNoteBook(noteBooks);
        System.out.print("Ваш критерий: ");
        Integer indicator = iScanner.nextInt();
        HashSet<Object> temp = new HashSet<>();
        temp = firstFilterItem(noteBooks, indicator);
        System.out.println(temp);
        Object[] arr = new Object[2];
        if (indicator == 1 || indicator == 2) {
            System.out.print("Ваша подборка от Min До Max(через пробел): ");
            iScanner.nextLine();
            String strTemp = iScanner.nextLine();
            System.out.println(strTemp);
            String[] arr2 = strTemp.split(" ");
            arr = new Integer[2];
            arr[0] = Integer.parseInt(arr2[0]);
            arr[1] = Integer.parseInt(arr2[1]);
            Arrays.sort(arr);
        } else {
            System.out.print("Ваша подборка: ");
            iScanner.nextLine();
            String strTemp = iScanner.nextLine();
            arr = strTemp.split(" ");
        }

        HashSet<NoteBook> noteBooksEnd = new HashSet<>();
        noteBooksEnd = finishFilter(noteBooks, indicator, arr);
        // SortedSet<NoteBook> sortSet = new NoteBook(4, 64, "winda", "красный");

        if (noteBooksEnd.isEmpty()) {
            System.out.println("Таких ноутбуков нет!");
        } else {
            if (indicator == 1) {
                // System.out.println(noteBooksEnd);
                ArrayList<NoteBook> sortList = new ArrayList<>(noteBooksEnd);
                // System.out.println(sortList);
                Collections.sort(sortList, new Comparator<NoteBook>() {
                    @Override
                    public int compare(NoteBook p1, NoteBook p2) {
                        return p1.getOzy() - p2.getOzy();
                    }
                });
                System.out.println(sortList);
            } else if (indicator == 2) {
                // System.out.println(noteBooksEnd);
                ArrayList<NoteBook> sortList = new ArrayList<>(noteBooksEnd);
                // System.out.println(sortList);
                Collections.sort(sortList, new Comparator<NoteBook>() {
                    @Override
                    public int compare(NoteBook p1, NoteBook p2) {
                        return p1.getMemory() - p2.getMemory();
                    }
                });
                System.out.println(sortList);
            } else {
                // System.out.println(noteBooksEnd);
                ArrayList<NoteBook> sortList = new ArrayList<>(noteBooksEnd);
                // System.out.println(sortList);
                Collections.sort(sortList, new Comparator<NoteBook>() {
                    @Override
                    public int compare(NoteBook p1, NoteBook p2) {
                        return p1.getMemory() - p2.getMemory();
                    }
                });
                System.out.println(sortList);
            }

        }
        iScanner.close();
    }

    public static HashSet<NoteBook> finishFilter(HashSet<NoteBook> noteBooks, Integer indicator, Object[] arr) {
        HashSet<NoteBook> temp = new HashSet<>();
        // System.out.println((Integer)arr[0]);
        // System.out.println((Integer)arr[1]);
        if (indicator == 1) {
            for (NoteBook item : noteBooks) {
                if (item.getOzy() >= (Integer) arr[0] && item.getOzy() <= (Integer) arr[1]) {
                    temp.add(item);
                }
            }
        } else if (indicator == 2) {
            for (NoteBook item : noteBooks) {
                if (item.getMemory() >= (Integer) arr[0] && item.getMemory() <= (Integer) arr[1]) {
                    temp.add(item);
                }
            }
        } else if (indicator == 3) {
            for (NoteBook item : noteBooks) {
                if (item.getSistem().equals(arr[0])) {
                    temp.add(item);
                }
            }
        } else if (indicator == 4) {
            for (NoteBook item : noteBooks) {
                if (item.getColor().equals(arr[0])) {
                    temp.add(item);
                }
            }
        }
        return temp;
    }

    public static HashSet<Object> firstFilterItem(HashSet<NoteBook> noteBooks, Integer indicator) {
        HashSet<Object> temp = new HashSet<>();

        if (indicator == 1) {
            // HashSet<Integer> temp = new HashSet<>();
            for (NoteBook item : noteBooks) {
                temp.add(item.getOzy());
            }
            return temp;

        } else if (indicator == 2) {
            // HashSet<Integer> temp = new HashSet<>();
            for (NoteBook item : noteBooks) {
                temp.add(item.getMemory());
            }
            return temp;

        } else if (indicator == 3) {
            // HashSet<String> temp = new HashSet<>();
            for (NoteBook item : noteBooks) {
                temp.add(item.getSistem());
            }
            return temp;

        } else if (indicator == 4) {
            // HashSet<String> temp = new HashSet<>();
            for (NoteBook item : noteBooks) {
                temp.add(item.getColor());
            }
            return temp;

        }
        return temp;

    }

    public static void createNoteBook(HashSet<NoteBook> noteBooks) {
        NoteBook noteBook1 = new NoteBook(4, 64, "winda", "красный");
        NoteBook noteBook2 = new NoteBook(6, 128, "winda", "зелёный");
        NoteBook noteBook3 = new NoteBook(3, 128, "linux", "чёрный");
        NoteBook noteBook4 = new NoteBook(3, 210, "winda", "чёрный");
        NoteBook noteBook5 = new NoteBook(7, 256, "winda", "красный");
        noteBooks.add(noteBook1);
        noteBooks.add(noteBook2);
        noteBooks.add(noteBook3);
        noteBooks.add(noteBook4);
        noteBooks.add(noteBook5);
        // return noteBooks;
    }

    public static void welcomeMainMenu() {
        System.out.println("Введите цифру, соответствующую необходимому критерию: ");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД hd hdd");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
    }

}

class NoteBook {
    private Integer ozy;
    private Integer memory;
    private String sistem;
    private String color;

    public NoteBook(Integer ozy, Integer memory, String sistem, String color) {
        this.ozy = ozy;
        this.memory = memory;
        this.sistem = sistem;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public Integer getMemory() {
        return memory;
    }

    public Integer getOzy() {
        return ozy;
    }

    public String getSistem() {
        return sistem;
    }

    @Override
    public String toString() {
        return "озу->" + this.ozy + " память->" + this.memory + " операционка->" + this.sistem + " цвет->" + this.color
                + "\n";
    }

    @Override
    public boolean equals(Object o) {
        NoteBook t = (NoteBook) o;
        return ozy == t.ozy;
    }
}    
class lol {
    public static boolean containValue(Integer indicator, HashSet<Object> temp,
    Scanner iScanner) {
    if (indicator == 1 || indicator == 2) {
    System.out.print("Задайте минимальные значения для критерия через пробел: ");
    Integer strTemp = iScanner.nextInt();
    System.out.println(temp.contains(strTemp));
    if (temp.contains(strTemp)) {
    return true;
    }
    

    } else if (indicator == 3 || indicator == 4) {
    if (indicator == 3) {
    System.out.print("Введите операционную систему: ");
    } else {
    System.out.print("Какого цвета нужен ноутбук?: ");
    }
    String strTemp = iScanner.next();
    System.out.println(temp.contains(strTemp));
    if (temp.contains(strTemp)) {
    return true;
    }
    
    }
    return false;
    }
}