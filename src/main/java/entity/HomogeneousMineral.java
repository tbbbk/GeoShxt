package entity;

public class HomogeneousMineral {
    private int id;
    private String name;
    //均非性
    private String heterOrHomo;
    //反射率视测等级
    private String reflectanceVisualInspectionLevel;
    //反射色视测分级
    private String visualClassificationOfReflectivity;
    //双反射
    private String doubleReflection;
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
    //色散
    private String Dispersion;
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getHeterOrHomo() {
        return heterOrHomo;
    }

    public void setHeterOrHomo(String heterOrHomo) {
        this.heterOrHomo = heterOrHomo;
    }

    public String getDoubleReflection() {
        return doubleReflection;
    }

    public void setDoubleReflection(String doubleReflection) {
        this.doubleReflection = doubleReflection;
    }

    public String getDispersion() {
        return Dispersion;
    }

    public void setDispersion(String dispersion) {
        Dispersion = dispersion;
    }

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

    public HomogeneousMineral(Integer id) {
        this.id = id;
    }

    public HomogeneousMineral(String name) {
        this.name = name;
    }

    public HomogeneousMineral(String name, String heterOrHomo, String reflectanceVisualInspectionLevel, String visualClassificationOfReflectivity, String doubleReflection, String internalReflection, String markHardness, String mohsHardness, String vickersHardness, String reflectionRotationAngle, String dispersion, String info) {
        this.name = name;
        this.heterOrHomo = heterOrHomo;
        this.reflectanceVisualInspectionLevel = reflectanceVisualInspectionLevel;
        this.visualClassificationOfReflectivity = visualClassificationOfReflectivity;
        this.doubleReflection = doubleReflection;
        this.internalReflection = internalReflection;
        this.markHardness = markHardness;
        this.mohsHardness = mohsHardness;
        this.vickersHardness = vickersHardness;
        this.reflectionRotationAngle = reflectionRotationAngle;
        Dispersion = dispersion;
        this.info = info;
    }

    @Override
    public String toString() {
        return "HomogeneousMineral{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", heterOrHomo='" + heterOrHomo + '\'' +
                ", reflectanceVisualInspectionLevel='" + reflectanceVisualInspectionLevel + '\'' +
                ", visualClassificationOfReflectivity='" + visualClassificationOfReflectivity + '\'' +
                ", doubleReflection='" + doubleReflection + '\'' +
                ", internalReflection='" + internalReflection + '\'' +
                ", markHardness='" + markHardness + '\'' +
                ", mohsHardness='" + mohsHardness + '\'' +
                ", vickersHardness='" + vickersHardness + '\'' +
                ", reflectionRotationAngle='" + reflectionRotationAngle + '\'' +
                ", Dispersion='" + Dispersion + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
