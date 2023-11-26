package event;

import Charactor.*;

public class Event {
	public static boolean MainCharacterHit(MainCharacter MainCharacter,Objects objects,int MainCharacterSize,int Height){
        if( MainCharacter.x + MainCharacterSize > objects.x && MainCharacter.x < objects.x) {
                if(MainCharacter.y + MainCharacterSize >= objects.y - Height) {
                    return true;
                }
            }
            return false;
        }   

}