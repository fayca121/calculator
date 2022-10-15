package dz.bououza;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalculatorService {
    public int sum(int x,int y){
        return x+y;
    }
}
