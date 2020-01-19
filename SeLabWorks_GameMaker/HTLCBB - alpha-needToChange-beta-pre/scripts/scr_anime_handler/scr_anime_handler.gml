//handle animation of different movements 

switch(myStatus){
	case STATE_UNLOCK:
		if(onTheGround){
			if(!isDucking){
				isCanBeAttacked = true;
				if(horSpeed ==0){
					scr_set_sprites_movement(spr_idle);
				}
				else{
					sprite_index= (sign(horSpeed)==sign(image_xscale))?spr_to_right:spr_to_left;
		
				}
				
			}
			else{
				//change to crouch
				//if(!scr_set_sprites_movement(spr_crouch)){
				//	scr_set_sprites_unloop();
				//}
			
				scr_set_sprites_movement(spr_crouch)
					isCanBeAttacked = false;
					
			}
		
		}
		else{ // not on the ground
			if(verSpeed >0){
				scr_set_sprites_movement(spr_fall);
			}
			else{
				if(!isJumpAttack){
					scr_set_sprites_movement(spr_jump);
				}
				else{
					scr_set_sprites_movement(spr_attack[3]);	
					
					
				}
				
			
			}
		}
			
		
		break
		
		case STATE_ATTACK:
			if (!can_attack){
				exit;
			}
			if(onTheGround){
				if(!isDucking){
					scr_set_sprites_movement(spr_attack[attack_type]);
				}
			}
			can_attack = false;
		break
}

