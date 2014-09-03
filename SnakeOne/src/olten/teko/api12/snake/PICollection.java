
package olten.teko.api12.snake;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Stefan
 */
public class PICollection {
    
    protected Collection<PowerItems> items = new ArrayList<>();
    
    //items.size() + 1
    public void addBanana(String object, int pointUnit, int dots, int delay){
        PowerItems banana = new PowerItems("banana", pointUnit, object, dots, delay);
        items.add(banana);
    }
    
    public void addFungus(String object, int pointUnit, int dots, int delay){
        PowerItems fungus = new PowerItems("fungus", pointUnit, object, dots, delay);
        items.add(fungus);
    }
    
    public void addApple(String object, int pointUnit, int dots, int delay){
        PowerItems apple = new PowerItems("apple", pointUnit, object, dots, delay);
        items.add(apple);
    }
    
    public void addPill(String object, int pointUnit, int dots, int delay){
        PowerItems pill = new PowerItems("pill", pointUnit, object, dots, delay);
        items.add(pill);
    }
       
    public PowerItems getItem(){
        for (PowerItems item : this.items) {
            return item;
        }
        return null;
    }
    
    public PowerItems getPill() {
        for (PowerItems item : this.items) {
            
            if(item.getName().equals("pill")){
                return item;
            }

            
        }
        return null;
    }
            
            
            

        
    
}
