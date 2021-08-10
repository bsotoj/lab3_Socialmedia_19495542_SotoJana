

public interface Authentication {
    void register(String nombreUsuario, String contrasegna);
    void login (String nombreUsuario, String constrasegna);
    void logout();
}
