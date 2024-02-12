public record ClienteDTO(Long id, String nombreCompleto, String direccionCompleta, String pais) {

    public static ClienteDTO of(Cliente c) {
        return new ClienteDTO(
                c.getId(),
                c.getNombre() + " " + c.getApellidos(),
                c.getDireccion().getCalle() + " " + c.getDireccion().getCiudad() + " " + c.getDireccion().getCodPostar() + " " + c.getDireccion().getProvincia(),
                c.getDireccion().getPais());
    }
}

@GetMapping("/api/song")
public ResponseEntity<Song> getAll(){
    List<Song> lista = songService.findAll();
    if(lista.isEmpty)
        return ResponseEntity.notFound().build();

    return ResponseEntity.ok(lista);
}

@DeleteMapping("/api/song/{id}")
public ResponseEntity<?> deleteSong(@PathVariable Long id){
    if(!repositorio.existsById(id))
        return ResponseEntity.notFound().build();

        repositorio.removeById(id)
    return ResponseEntity.noContent().build();
}

Optional<Song> song =repositorio.findById(id);
song.map(s->s.getName=="NuevoNombre");