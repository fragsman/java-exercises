package utils;

public enum ExerciseType {
    ALGORITHM("Algorithm"),
    FILE("File"),
    MATH("Math"),
    OBJECT("Object"),
    SEARCH("Search"),
    STRING("String"),
    STRUCTURE("Structure"),
    VISUAL("Visual");

    private final String exerciseType;

    ExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public String getValue(){
        return this.exerciseType;
    }

}
