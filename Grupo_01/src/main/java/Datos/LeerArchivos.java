package Datos;

import TDAS.ListaCircularDoble;
import java.io.File;
import java.util.Locale;

public final class LeerArchivos {
    // Evita que se instancie la clase
    private LeerArchivos() {
        throw new AssertionError("Utility class – do not instantiate");
    }

    public static ListaCircularDoble<String> listaR() {
        return cargarDe("faces");
    }

    public static ListaCircularDoble<String> listaO() {
        return cargarDe("eyes");
    }

    public static ListaCircularDoble<String> listaB() {
        return cargarDe("mouth");
    }

    // Método común para no repetir código
    private static ListaCircularDoble<String> cargarDe(String subDir) {
        ListaCircularDoble<String> lista = new ListaCircularDoble<>();
        String ruta = "src/main/resources/images/" + subDir + "/";
        String extension = ".png";

        File folder = new File(ruta);
        File[] archivos = folder.listFiles((dir, name) ->
            name.toLowerCase(Locale.ROOT).endsWith(extension)
        );

        if (archivos != null) {
            for (File f : archivos) {
                lista.add("file:" + f.getAbsolutePath());
            }
        }
        return lista;
    }
}
