switch (myStatus){
	case STATE_ATTACK:
	if(onTheGround){
		if(!isDucking){
			if(attack_type = ATTACK_PUNCH){
				if(image_index>=2) and (image_index<=3){
					scr_create_attack(self,1,obj_punch_hitbox)
				
				}
			
			}
			else if(attack_type = ATTACK_LOW_PUNCH){
				if(image_index>=0) and (image_index<=2){
					scr_create_attack(self,1,obj_low_punch_hitbox)
				
				}
			
			}
			
			else if(attack_type = ATTACK_KICK){
				if(image_index>=1) and (image_index<=3){
					scr_create_attack(self,1,obj_kick_hitbox)
				
				}
				
			
			}
			else if(attack_type = ATTACK_BLOCK){
				if(image_index>=0) and (image_index<=1){
					isBlock =true;
				
				}
				
			
			}
		
			else if(attack_type = ATTACK_SPECIAL_ATTACK){
				if(global.isCanSpecialAttack ){
					if(image_index >=3 and (image_index <=4)){
						var h = instance_create_layer(x,y,"Instances",obj_special);
						h.image_xscale = other.image_xscale;
						h.owner = self;
						h.damage = 1;
					
				
						with h{
							//find direction 
						
							h.speed = h.image_xscale*100;
							h.direction = image_angle;
							h.image_angle = image_angle
					
					
							//other.specialAttackCounter = other.specialAttackCounter - isSpecialAttackUsed?1:0;
						}
						alarm[3] = 2; //keep attacking
						
						alarm[2] = 100;//switch to can not attack
					}
				}
				
				
			
				
				}
				
			

				
				/**var damage, x_offset, y_offset;

				x_offset = argument2;
				y_offset = argument3;





				h.damage = damage;
				h.x_offset = x_offset;
				h.y_offset = y_offset;**/
			
			
	
	}
	if(attack_type = ATTACK_LOW_KICK){
				if(image_index>=1) and (image_index<=3){
					scr_create_attack(self, 1, obj_low_kick_hitbox)
				
				}
			}
	if(attack_type = ATTACK_CROUCH_PUNCH){
				if(image_index>=0) and (image_index<=3){
					scr_create_attack(self, 1, obj_crouch_punch_hitbox)
				
				}
			}	
	if(attack_type = ATTACK_CROUCH_SPECIAL){
		if (global.isCanSpecialAttack){
					if(image_index >=0 and (image_index <=3)){
						var h = instance_create_layer(x,y,"Instances",obj_crouch_special);
						h.image_xscale = other.image_xscale;
						h.owner = self;
						h.damage = 1;
					
				
						with h{
							//find direction 
						
							h.speed = h.image_xscale*100;
							h.direction = image_angle;
							h.image_angle = image_angle
					
					
							//other.specialAttackCounter = other.specialAttackCounter - isSpecialAttackUsed?1:0;
						}
						alarm[3] = 2; //keep attacking
						
						alarm[2] = 100;//switch to can not attack
					}
				}
	}
}
if(!onTheGround){
	if(attack_type = ATTACK_JUMP_KICK){
		if(image_index>=1) and (image_index<=4){
					scr_create_attack(self,1,obj_jump_kick_hitbox)
					
				
				}
	}
		if(attack_type = ATTACK_JUMP_SPECIAL){
			if(global.isCanSpecialAttack){
					if(image_index >=1 and (image_index <=3)){
						var h = instance_create_layer(x,y,"Instances",obj_special);
						h.image_xscale = other.image_xscale;
						h.owner = self;
						h.damage = 1;
					
				
						with h{
							//find direction 
						
							h.speed = h.image_xscale*100;
							h.direction = image_angle;
							h.image_angle = image_angle
					
					
							//other.specialAttackCounter = other.specialAttackCounter - isSpecialAttackUsed?1:0;
						}
						alarm[3] = 2; //keep attacking
						
						alarm[2] = 100;//switch to can not attack
					}
				}
		}
}
	break
}

if(hit ==1){
	horSpeed -=5*sign(image_xscale);
	hit =0;
	
}