package entity;

public class HomogeneousMineral {
    private int id;
    private String name;
    //反射率视测等级
    private String reflectanceVisualInspectionLevel;
    //反射色视测分级
    private String visualClassificationOfReflectivity;
    //内反射
    private String internalReflection;
    //刻划硬度
    private String markHardness;
    //摩氏硬度
    private String mohsHardness;
    //维克硬度
    private String vickersHardness;
    //反射视旋转角
    private String reflectionRotationAngle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReflectanceVisualInspectionLevel() {
        return reflectanceVisualInspectionLevel;
    }

    public void setReflectanceVisualInspectionLevel(String reflectanceVisualInspectionLevel) {
        this.reflectanceVisualInspectionLevel = reflectanceVisualInspectionLevel;
    }

    public String getVisualClassificationOfReflectivity() {
        return visualClassificationOfReflectivity;
    }

    public void setVisualClassificationOfReflectivity(String visualClassificationOfReflectivity) {
        this.visualClassificationOfReflectivity = visualClassificationOfReflectivity;
    }

    public String getInternalReflection() {
        return internalReflection;
    }

    public void setInternalReflection(String internalReflection) {
        this.internalReflection = internalReflection;
    }

    public String getMarkHardness() {
        return markHardness;
    }

    public void setMarkHardness(String markHardness) {
        this.markHardness = markHardness;
    }

    public String getMohsHardness() {
        return mohsHardness;
    }

    public void setMohsHardness(String mohsHardness) {
        this.mohsHardness = mohsHardness;
    }

    public String getVickersHardness() {
        return vickersHardness;
    }

    public void setVickersHardness(String vickersHardness) {
        this.vickersHardness = vickersHardness;
    }

    public String getReflectionRotationAngle() {
        return reflectionRotationAngle;
    }

    public void setReflectionRotationAngle(String reflectionRotationAngle) {
        this.reflectionRotationAngle = reflectionRotationAngle;
    }

    public HomogeneousMineral() {
    }

    public HomogeneousMineral(String name, String reflectanceVisualInspectionLevel, String visualClassificationOfReflectivity, String internalReflection, String markHardness, String mohsHardness, String vickersHardness, String reflectionRotationAngle) {
        this.name = name;
        this.reflectanceVisualInspectionLevel = reflectanceVisualInspectionLevel;
        this.visualClassificationOfReflectivity = visualClassificationOfReflectivity;
        this.internalReflection = internalReflection;
        this.markHardness = markHardness;
        this.mohsHardness = mohsHardness;
        this.vickersHardness = vickersHardness;
        this.reflectionRotationAngle = reflectionRotationAngle;
    }

    @Override
    public String toString() {
        return "HomogeneousMineral{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reflectanceVisualInspectionLevel='" + reflectanceVisualInspectionLevel + '\'' +
                ", visualClassificationOfReflectivity='" + visualClassificationOfReflectivity + '\'' +
                ", internalReflection='" + internalReflection + '\'' +
                ", markHardness='" + markHardness + '\'' +
                ", mohsHardness='" + mohsHardness + '\'' +
                ", vickersHardness='" + vickersHardness + '\'' +
                ", reflectionRotationAngle='" + reflectionRotationAngle + '\'' +
                '}';
    }
}
