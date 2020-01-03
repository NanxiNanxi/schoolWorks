switch(myStatus){
	case STATE_UNLOCK:
		can_attack = true;
		if (onTheGround){
			if(!isDucking){
				horSpeed = SPEED_WALK *(keyboard_check(toRight)-keyboard_check(toLeft));
			}
			else{
				horSpeed =0;
			}
			if(keyboard_check_pressed(up)){
				verSpeed = JUMP_FORCE;
				onTheGround = false;
				
			}
			//check if the player is crouching
			isDucking = keyboard_check(down);
		}
		else{ // above the ground
		
			
		
		}
		//attack movements
		
		if (keyboard_check_pressed(K_PUNCH)){
			scr_set_attack(ATTACK_PUNCH); break
		}
		else if (keyboard_check_pressed(K_BLOCK)){
			scr_set_attack(ATTACK_BLOCK); break
		}
		else if (keyboard_check_pressed(K_KICK)){
			scr_set_attack(ATTACK_KICK); break
		}
		
	break;
	
	case STATE_ATTACK:
		if(onTheGround){
			horSpeed = 0;
		}
		if(scr_check_anime_finish()){
			myStatus = STATE_UNLOCK;
		}
	break
}


if(onTheGround) {
	image_xscale = (myEnemy.x>x)?1:-1;
}