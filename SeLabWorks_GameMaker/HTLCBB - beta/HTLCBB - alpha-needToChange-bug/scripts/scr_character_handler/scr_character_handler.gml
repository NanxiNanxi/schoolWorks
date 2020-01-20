switch(myStatus){
	case STATE_UNLOCK:
		can_attack = true;
		if (onTheGround){
			if(!isDucking){
				//can check the direction
				horSpeed = SPEED_WALK *(keyboard_check(toRight)-keyboard_check(toLeft));
			}
			else{
				horSpeed =0;
			}
			if(keyboard_check_pressed(up)){
				verSpeed = JUMP_FORCE;
				onTheGround = false;
				
			}
			if(keyboard_check_released(K_SPECIAL_PRE)){
				if(keyboard_check_pressed(K_LOW_KICK)){
					scr_set_attack(ATTACK_LOW_KICK)
				}
			
			}
			
			//check if the player is crouching
			isDucking = keyboard_check(down);
			
		
		}
		else{ // above the ground
			
			if(keyboard_check_pressed(K_JUMP_KICK)){
				scr_set_attack(ATTACK_JUMP_KICK)
				var direct = (myEnemy.x>x)?1:-1
				horSpeed = 7*direct
				isJumpAttack = true;
			
		}
	
		
		}
		//attack movements
		
		if (keyboard_check_pressed(K_PUNCH)){
			scr_set_attack(ATTACK_PUNCH);
		}
		else if (keyboard_check_pressed(K_BLOCK)){
			scr_set_attack(ATTACK_BLOCK);
			
		}
		else if (keyboard_check_pressed(K_KICK)){
			scr_set_attack(ATTACK_KICK);
		}
		if(specialAttackCounter > 0){
				if(keyboard_check_pressed(K_SPECIAL_ATTACK)){
					scr_set_attack(ATTACK_SPECIAL_ATTACK);
				}
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