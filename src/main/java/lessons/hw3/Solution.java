package lessons.hw3;

import java.util.ArrayList;
import java.util.List;

public final class Solution {

  private Solution() { }

  public static void main(String[] args) {
    List<Grade> johnGrades = List.of(
      new Grade("Language", 88.5),
      new Grade("Physics", 92.3),
      new Grade("Math", 82.7)
    );

    List<Grade> kateGrades = List.of(
      new Grade("Language", 78.8),
      new Grade("Physics", 86.2),
      new Grade("Math", 94.1)
    );

    List<Grade> smithGrades = List.of(
      new Grade("Language", 81.8),
      new Grade("Physics", 84.2),
      new Grade("Math", 91.5)
    );

    List<Grade> saraGrades = List.of(
      new Grade("Language", 77.8),
      new Grade("Physics", 87.8),
      new Grade("Math", 92.2)
    );

    List<Grade> peterGrades = List.of(
      new Grade("Language", 85.3),
      new Grade("Physics", 88.8),
      new Grade("Math", 94.5)
    );

    List<Student> students = new ArrayList<>();
    students.add(new Student("John", 19, johnGrades, "Plymouth", new Address("New York", "Central str.")));
    students.add(new Student("Kate", 20, kateGrades, "LA", new Address("New York", "South str.")));
    students.add(new Student("Smith", 21, smithGrades, "NC", new Address("New York", "Main str.")));
    students.add(new Student("Sara", 14, saraGrades, "Dakota", new Address("New York", "Thriller str.")));
    students.add(new Student("Peter", 18, peterGrades, "Florida", new Address("Oviedo", "Palm beach str.")));

    List<StudentGrade> grades = students.stream()
      .filter(student -> student.age() > 15 && student.address() != null && student.address().city() != null && student.address().city().equals("New York"))
      .flatMap(student -> student.grades().stream()
        .map(grade -> new StudentGrade(student.name(), student.school(), grade.subject(), grade.score())))
      .limit(3)
      .sorted((gr1, gr2) -> Double.compare(gr2.score(), gr1.score()))
      .toList();

    grades.stream()
      .forEach(grade -> System.out.println(
        grade.studentName() + ", " + grade.school() + ", " + grade.subject() + ", " + grade.score()
      ));
  }
}
