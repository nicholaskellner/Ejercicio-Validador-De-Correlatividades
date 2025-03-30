import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

class TestInscripcion {
    Asignatura matematica = new Asignatura("Matematica", List.of(), List.of());
    Asignatura fisica = new Asignatura("Fisica", List.of(matematica), List.of());

    @Test
    @DisplayName("Test de Inscripcion Valida")
    public void testInscripcionValida() {
        Alumno alumnoAprobado = new Alumno("Juan", List.of(matematica), List.of());
        Inscripcion inscripcionValida = new Inscripcion(alumnoAprobado, List.of(fisica));

        Assertions.assertTrue(inscripcionValida.aprobada());
    }

    @Test
    @DisplayName("Test de Inscripcion Invalida")
    public void testInscripcionInvalida() {

        Alumno alumnoNoAprobado = new Alumno("Pedro", List.of(), List.of());
        Inscripcion inscripcionInvalida = new Inscripcion(alumnoNoAprobado, List.of(fisica));

        Assertions.assertFalse(inscripcionInvalida.aprobada());
    }
}