/*package com.TP_API_Jakarta.TP_API_Jakarta;
import org.springframework.stereotype.Service;

@Service
public class BilletService {

    @Autowired 
    private BilletRepository repository; 

    public Billet save(Billet billet) {
        return repository.save(billet);
    }

    public Billet ajoutBillet(String billetID) {
        Billet billet = repository.findById(billetID).orElse(null); 
        if (billet != null){
        repository.save(billet);
        }
        return billet;
    }
}
*/