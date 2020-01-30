switch(myStatus){
	case STATE_UNLOCK:
		can_attack = true;
		if (onTheGround){
			if(!isDucking){
				//can check the direction
				horSpeed = SPEED_WALK *(max(keyboard_check(toRight),C_RIGHT_PRESSED,0)-max(keyboard_check(toLeft),C_LEFT_PRESSED,0));
			}
			else{
				horSpeed =0;
			}
			if(max(keyboard_check_pressed(up),0,gamepad_button_check_pressed(C_CONTROLLER,gp_padu))){
				verSpeed = JUMP_FORCE;
				onTheGround = false;
				
			}
			isCrouching = max(keyboard_check(down),0,gamepad_button_check(C_CONTROLLER,gp_padd));
			if(isCrouching){
					if(max(keyboard_check_pressed(K_LOW_KICK),0,C_LOW_KICK_PRESSED)==1) {
						//isLowKicking = true;
					scr_set_attack(ATTACK_LOW_KICK)
					}
					if(max(keyboard_check_pressed(K_PUNCH),0,C_HIGH_PUNCH_PRESSED)==1) {
						
					scr_set_attack(ATTACK_CROUCH_PUNCH)
					}
					if(max(keyboard_check_pressed(K_BLOCK),0,C_BLOCK_PRESSED)==1) {
						scr_set_attack(ATTACK_CROUCH_BLOCK)
						isCrouchBlocking = true	
					
					}
			
			
			}
				
			//check if the player is crouching
			isDucking = max(keyboard_check(down),0,gamepad_button_check(C_CONTROLLER,gp_padd));
			
			if (max(keyboard_check_pressed(K_PUNCH),0,C_HIGH_PUNCH_PRESSED)==1 && !isCrouching){
			scr_set_attack(ATTACK_PUNCH);
		}
		if (max(keyboard_check_pressed(K_LOW_PUNCH),0,C_LOW_PUNCH_PRESSED)==1){
			scr_set_attack(ATTACK_LOW_PUNCH);
		}
		else if (max(keyboard_check_pressed(K_BLOCK),0,C_BLOCK_PRESSED)==1 && !isCrouching){
			scr_set_attack(ATTACK_BLOCK);
			
		}
		else if (max(keyboard_check_pressed(K_KICK),0,C_HIGH_KICK_PRESSED)==1 && !isCrouching){
			scr_set_attack(ATTACK_KICK);
		}
		
		else if(max(keyboard_check_pressed(K_SPECIAL_ATTACK),0,C_SPECIAL_ATTACK_PRESSED)==1){
			scr_set_attack(ATTACK_SPECIAL_ATTACK);
		}
		
		}
		else{ // above the ground
			
			if(max(keyboard_check_pressed(K_JUMP_KICK),0,C_JUMP_KICK_PRESSED)==1){
				scr_set_attack(ATTACK_JUMP_KICK)
				var direct = (myEnemy.x>x)?1:-1
				horSpeed = 7*direct
				isJumpAttack = true;
			
		}
	
		
		}
		//attack movements
		
		
			
		
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
