package company;

import java.util.Comparator;

/*Created a comparator class to sort points*/
public class Comparatorclass implements Comparator<Formula1driver> {

    @Override
    public int compare(Formula1driver firstPosition, Formula1driver secondPosition) {
        if (firstPosition.getPoints() > secondPosition.getPoints()) {
            return -1;
        } else if (secondPosition.getPoints() > firstPosition.getPoints()) {
            return 1;
        } else {

            int firstOne = firstPosition.getNo_of_first_pos();
            int secondOne = secondPosition.getNo_of_second_pos();
            if (firstOne > secondOne)
                return -1;
            else if (secondOne > firstOne) {
                return 1;

            } else {
                return 0;
            }

        }
    }
}
//references---->https://www.geeksforgeeks.org/comparator-interface-java/


