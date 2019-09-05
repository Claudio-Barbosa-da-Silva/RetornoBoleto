
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author telecentro
 */
public class ProcessarBoletos {
    
    private LeituraRetorno leituraRetorno;

    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
    
    public ProcessarBoletos(LeituraRetorno leituraRetorno){
        this.leituraRetorno = leituraRetorno;
    }
    
    public void processar(String nomeArquivo){
       List<Boleto> boletos =  leituraRetorno.lerArquivo(nomeArquivo);
    
    }
    
    
}
