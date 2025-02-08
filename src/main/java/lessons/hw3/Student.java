package lessons.hw3;

import java.util.List;

public record Student (String name, Integer age, List<Grade> grades, String school, Address address) {}
