import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UsuarioTest {

    @Test
    void deveNotificarUmUsuarioDoEmailRecebido() {
        Email email = new Email("ana@email.com", "10/02/2022", "Lorem Ipson", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        Usuario usuario = new Usuario("walkiria@email.com");
        usuario.receber(email);
        email.EnviarEmail();
        assertEquals("walkiria@email.com, email recebido: E-mail{remetente='ana@email.com', data='10/02/2022', assunto='Lorem Ipson', mensagem='Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'}", usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarDoisUsuariosDoEmailRecebido() {
        Email email = new Email("ana@email.com", "10/02/2022", "Lorem Ipson", "Sed ut perspiciatis unde omnis iste natus error");
        Usuario usuario1 = new Usuario("walkiria@email.com");
        Usuario usuario2 = new Usuario("pedro@email.com");
        usuario1.receber(email);
        usuario2.receber(email);
        email.EnviarEmail();
        assertEquals("walkiria@email.com, email recebido: E-mail{remetente='ana@email.com', data='10/02/2022', assunto='Lorem Ipson', mensagem='Sed ut perspiciatis unde omnis iste natus error'}", usuario1.getUltimaNotificacao());
        assertEquals("pedro@email.com, email recebido: E-mail{remetente='ana@email.com', data='10/02/2022', assunto='Lorem Ipson', mensagem='Sed ut perspiciatis unde omnis iste natus error'}", usuario2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarAluno() {
        Email email = new Email("ana@email.com", "10/02/2022", "Lorem Ipson", "Sed ut perspiciatis unde omnis iste natus error");
        Usuario usuario = new Usuario("walkiria@email.com");
        email.EnviarEmail();
        assertEquals(null, usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarSomenteUsuarioDoEmail1() {
        Email email1 = new Email("ana@email.com", "10/02/2022", "Lorem Ipson", "Sed ut perspiciatis unde omnis iste natus error");
        Email email2 = new Email("pedro@email.com", "9/02/2022", "Ipson Lorem", "Lorem ipsum dolor sit amet, ");
        Usuario usuario1 = new Usuario("walkiria@email.com");
        Usuario usuario2 = new Usuario("pedro@email.com");
        usuario1.receber(email1);
        usuario2.receber(email2);
        email1.EnviarEmail();
        assertEquals("walkiria@email.com, email recebido: E-mail{remetente='ana@email.com', data='10/02/2022', assunto='Lorem Ipson', mensagem='Sed ut perspiciatis unde omnis iste natus error'}", usuario1.getUltimaNotificacao());
        assertEquals(null, usuario2.getUltimaNotificacao());
    }
}