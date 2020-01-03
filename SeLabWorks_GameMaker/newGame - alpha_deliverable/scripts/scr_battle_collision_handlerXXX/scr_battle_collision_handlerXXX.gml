switch (myStatus){
	case STATE_ATTACK:
	if(onTheGround){
		if(!isDucking){
			if(attack_type = ATTACK_PUNCH){
					if(image_index>=2) and (image_index<=3){
						with(instance_create_layer(x,y,"Instances",obj_punch_hitbox)){
							image_xscale =  other.image_xscale;
							with(p1){
								with(instance_place(x,y,p1.myEnemy)){
								if(hit ==0){
									hit = 1;
									verSpeed = -3;
									horSpeed = sign(x-other.x)*4;
									image_xscale = sign(horSpeed);
								}
							}
							
							}
							with(p2){
								with(instance_place(x,y,p2.myEnemy)){
								if(hit ==0){
									hit = 1;
									verSpeed = -3;
									horSpeed = sign(x-other.x)*4;
									image_xscale = sign(horSpeed);
								}
							}
							
							}
						}
					
					}
			}
			
		}
	}
		
	
	break

}