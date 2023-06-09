package entity;

import service.HeterogeneousMineralService;

//非均质
public class HeterogeneousMineral {
    private int id;
    private String name;
    //均非性
    private String homoOrHeter;
    //反射率视测等级
    private String reflectanceVisualInspectionLevel;
    //反射率视测分级
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
    //旋向
    private String Rotation;
    //相符
    private String Match;
    //光符
    private String lightSymbol;
    //非均质视旋转角
    private String non_HomogeneousViewRotationAngle;
    //色散
    private String Dispersion;
    //非均质视旋转色散
    private String non_HomogeneousVisualRotationColor;

    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getHomoOrHeter() {
        return homoOrHeter;
    }

    public void setHomoOrHeter(String homoOrHeter) {
        this.homoOrHeter = homoOrHeter;
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

    public String getDoubleReflection() {
        return doubleReflection;
    }

    public void setDoubleReflection(String doubleReflection) {
        this.doubleReflection = doubleReflection;
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

    public String getRotation() {
        return Rotation;
    }

    public void setRotation(String rotation) {
        Rotation = rotation;
    }

    public String getMatch() {
        return Match;
    }

    public void setMatch(String match) {
        Match = match;
    }

    public String getLightSymbol() {
        return lightSymbol;
    }

    public void setLightSymbol(String lightSymbol) {
        this.lightSymbol = lightSymbol;
    }

    public String getNon_HomogeneousViewRotationAngle() {
        return non_HomogeneousViewRotationAngle;
    }

    public void setNon_HomogeneousViewRotationAngle(String non_HomogeneousViewRotationAngle) {
        this.non_HomogeneousViewRotationAngle = non_HomogeneousViewRotationAngle;
    }

    public String getDispersion() {
        return Dispersion;
    }

    public void setDispersion(String dispersion) {
        this.Dispersion = dispersion;
    }

    public String getNon_HomogeneousVisualRotationColor() {
        return non_HomogeneousVisualRotationColor;
    }

    public void setNon_HomogeneousVisualRotationColor(String non_HomogeneousVisualRotationColor) {
        this.non_HomogeneousVisualRotationColor = non_HomogeneousVisualRotationColor;
    }


    public HeterogeneousMineral() {
    }

    public HeterogeneousMineral(Integer id) {
        this.id = id;
    }

    public HeterogeneousMineral(String name) {
        this.name = name;
    }

    public HeterogeneousMineral(String name, String homoOrHeter, String reflectanceVisualInspectionLevel, String visualClassificationOfReflectivity, String doubleReflection, String internalReflection, String markHardness, String mohsHardness, String vickersHardness, String rotation, String match, String lightSymbol, String non_HomogeneousViewRotationAngle, String dispersion, String non_HomogeneousVisualRotationColor, String info) {
        this.name = name;
        this.homoOrHeter = homoOrHeter;
        this.reflectanceVisualInspectionLevel = reflectanceVisualInspectionLevel;
        this.visualClassificationOfReflectivity = visualClassificationOfReflectivity;
        this.doubleReflection = doubleReflection;
        this.internalReflection = internalReflection;
        this.markHardness = markHardness;
        this.mohsHardness = mohsHardness;
        this.vickersHardness = vickersHardness;
        this.Rotation = rotation;
        this.Match = match;
        this.lightSymbol = lightSymbol;
        this.non_HomogeneousViewRotationAngle = non_HomogeneousViewRotationAngle;
        this.Dispersion = dispersion;
        this.non_HomogeneousVisualRotationColor = non_HomogeneousVisualRotationColor;
        this.info = info;
    }

    @Override
    public String toString() {
        return "HeterogeneousMineral{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", homoOrHeter='" + homoOrHeter + '\'' +
                ", reflectanceVisualInspectionLevel='" + reflectanceVisualInspectionLevel + '\'' +
                ", visualClassificationOfReflectivity='" + visualClassificationOfReflectivity + '\'' +
                ", doubleReflection='" + doubleReflection + '\'' +
                ", internalReflection='" + internalReflection + '\'' +
                ", markHardness='" + markHardness + '\'' +
                ", mohsHardness='" + mohsHardness + '\'' +
                ", vickersHardness='" + vickersHardness + '\'' +
                ", Rotation='" + Rotation + '\'' +
                ", Match='" + Match + '\'' +
                ", lightSymbol='" + lightSymbol + '\'' +
                ", non_HomogeneousViewRotationAngle='" + non_HomogeneousViewRotationAngle + '\'' +
                ", Dispersion='" + Dispersion + '\'' +
                ", non_HomogeneousVisualRotationColor='" + non_HomogeneousVisualRotationColor + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
