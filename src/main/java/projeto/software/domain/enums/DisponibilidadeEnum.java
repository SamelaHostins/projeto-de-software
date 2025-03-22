package projeto.software.domain.enums;

public enum DisponibilidadeEnum {
    DISPONIVEL(0),
    EMPREGADO(1);

    private final int disponibilidade;

    DisponibilidadeEnum(int disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getdisponibilidade() {
        return disponibilidade;
    }

    // Método personalizado para buscar o enum pelo valor inteiro
    public static DisponibilidadeEnum fromdisponibilidade(int disponibilidade) {
        for (DisponibilidadeEnum tipo : DisponibilidadeEnum.values()) {
            if (tipo.getdisponibilidade() == disponibilidade) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo disponibilidade inválido: " + disponibilidade);
    }
}