import java.util.Collections;
import java.util.Scanner;

public class Main{
    public static void main() {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o limite do cartao: ");
        double limite = leitura.nextDouble();
        leitura.nextLine();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while(sair != 0){
            System.out.println("Digite a descricao da compra:");
            String descricao = leitura.nextLine();

            System.out.println("Digite o valor da compra:");
            double valor = leitura.nextDouble();
            leitura.nextLine();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if(compraRealizada){
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = leitura.nextInt();
                leitura.nextLine();
            } else {
                System.out.println("Saldo insuficiente!");
                sair = 0;
            }
        }
        System.out.println("****************************");
        System.out.println("COMPRAS REALIZADAS:\n");

        Collections.sort(cartao.getCompras());

        for(Compra c : cartao.getCompras()){
            System.out.println(c.getDescricao() + " - " + c.getValor());
        }
        System.out.println("\n****************************");

        System.out.println("Saldo do cartao: " + cartao.getSaldo());
    }
}