
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author telecentro
 */
public class LeituraRetornoBancoBrasil implements LeituraRetorno{

    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
       try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            
            String ln;

            List<Boleto> boletos = new ArrayList<>();
            
            while((ln = reader.readLine())!= null){
                String[] vetor = ln.split(";");
                Boleto boleto = new Boleto();
                boleto.setId(Integer.valueOf(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setDataVencimento(LocalDate.parse(vetor[2]));
                boleto.setDataPagamento(LocalDateTime.parse(vetor[3]));
                boleto.setCpfCliente(vetor[4]);
                boleto.setValor(Double.valueOf(vetor[5]));
                boleto.setMulta(Double.valueOf(vetor[6]));
                boleto.setJuros(Double.valueOf(vetor[7]));
                boleto.setAgencia(vetor[8]);
                boleto.setContaBancaria(vetor[9]);
                
                boletos.add(boleto);
                
            }
            return boletos;
                    
        } catch (IOException ex) {
            Logger.getLogger(LeituraRetornoBradesco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Collections.emptyList();
    }
    
}
