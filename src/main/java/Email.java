import java.util.Observable;

public class Email extends Observable{

    private String remetente;
    private String data;
    private String assunto;
    private String mensagem;

    public Email(String remetente, String data, String assunto, String mensagem) {
        this.remetente = remetente;
        this.data = data;
        this.assunto = assunto;
        this.mensagem = mensagem;
    }

    public void EnviarEmail() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "E-mail{" +
                "remetente='" + remetente + '\'' +
                ", data='" + data + '\'' +
                ", assunto='" + assunto + '\'' +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }

}
