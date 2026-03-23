package principal;

import dao.UsuarioDao;
import modelo.Usuario;

public class Main {

    public static void main(String[] args) {

        UsuarioDao dao = new UsuarioDao();

        System.out.println("LISTA DE USUARIOS:");
        List<Usuario> lista = dao.listar();

        for (Usuario u : lista) {
            System.out.println(u.getId() + " - " + u.getUsuario() + " - " + u.getEmail());
        }
    }
}