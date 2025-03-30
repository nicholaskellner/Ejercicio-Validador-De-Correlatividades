import java.util.List;

class Asignatura {
    private String nombre;
    private List<Asignatura> correlativasAprobadas;
    private List<Asignatura> correlativasRegularizadas;

    public Asignatura (String nombre, List<Asignatura> correlativasAprobadas, List<Asignatura> correlativasRegularizadas) {
        this.nombre = nombre;
        this.correlativasAprobadas = correlativasAprobadas;
        this.correlativasRegularizadas = correlativasRegularizadas;
    }

    public List<Asignatura> getCorrelativasAprobadas() {
        return correlativasAprobadas;
    }

    public List<Asignatura> getCorrelativasRegularizadas() {
        return correlativasRegularizadas;
    }
}

class Alumno {
    private String nombre;
    private List<Asignatura> materiasAprobadas;
    private List<Asignatura> materiasRegularizadas;

    public Alumno (String nombre, List<Asignatura> materiasAprobadas, List<Asignatura> materiasRegularizadas) {
        this.nombre = nombre;
        this.materiasAprobadas = materiasAprobadas;
        this.materiasRegularizadas = materiasRegularizadas;
    }

    public boolean puedeCursar (Asignatura asignatura) {
        return materiasAprobadas.containsAll(asignatura.getCorrelativasAprobadas()) &&
                materiasRegularizadas.containsAll(asignatura.getCorrelativasRegularizadas());
    }
}

class Inscripcion {
    private Alumno alumno;
    private List<Asignatura> asignaturas;

    public Inscripcion (Alumno alumno, List<Asignatura> asignaturas) {
        this.alumno = alumno;
        this.asignaturas = asignaturas;
    }

    public boolean aprobada () {
        return asignaturas.stream().allMatch(materia -> alumno.puedeCursar(materia));
    }
}