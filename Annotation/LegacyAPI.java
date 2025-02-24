package Bridgelabz_2113100011.Assignment24.Annotations;

public class LegacyAPI {

    @Deprecated
    void oldFeature() {
        System.out.println("Old Feature method called..");
    }

    void newFeature() {
        System.out.println("New feature method called..");
    }

    public static void main(String[] args) {
        LegacyAPI legacyAPI = new LegacyAPI();
        legacyAPI.oldFeature();
        legacyAPI.newFeature();
    }
}
