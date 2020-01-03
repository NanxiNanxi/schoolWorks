switch (myStatus){
	case STATE_ATTACK:
	if(onTheGround){
		if(!isDucking){
			if(attack_type = ATTACK_PUNCH){
				if(image_index>=2) and (image_index<=3){
					scr_create_attack(self,1)
				
				}
				
			
			}
			
			
		}
	}
		
	
	break

}

if(hit ==1){
	horSpeed -=5*sign(image_xscale);
	//hp -= damage;
	hit =0;
	
}