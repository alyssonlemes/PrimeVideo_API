package unifacef.edu.primevideo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="filme")
public class FilmeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="nome")
    private String nome;

    @Column(name="anoLancamento")
    private int anoLancamento;

    @Column(name="nota")
    private float nota;

    public FilmeEntity() {
    }

    public FilmeEntity(long id, String nome, int anoLancamento, float nota) {
        this.id = id;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.nota = nota;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}
