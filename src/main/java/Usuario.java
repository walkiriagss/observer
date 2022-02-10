import java.util.Observable;
import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer{

    private String enderecoEmail;
    private String ultimaNotificacao;

    public Usuario(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void receber(Email email) {
        email.addObserver(this);
    }

    public void update(Observable email, Object arg1) {
        this.ultimaNotificacao = this.enderecoEmail + ", email recebido: " + email.toString();
    }

}
