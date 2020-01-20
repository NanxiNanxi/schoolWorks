/// @description Insert description here

if(isCanBeAttacked && isBlock = false){
		if other.owner == self
	{
		specialAttackCounter = specialAttackCounter - isSpecialAttackUsed;
		
		audio_play_sound(bgm_punch,1000, false)
		
		
		exit
	}


	hit = 1;
	audio_play_sound(bgm_pain_short,1000, false)
	hp -= other.damage;
	
	with other 
		instance_destroy()

}
else if(isCanBeAttacked && isBlock = true){
if other.owner == self
	{
		specialAttackCounter = specialAttackCounter - isSpecialAttackUsed;
		audio_play_sound(bgm_punch,1000, false)
		
		exit
	}

	hit = 1;
	hp -= 0;
	//specialAttackCounter -= specialAttackCounter;
	//specialAttackCounter  = specialAttackCounter+1;
	with other 
		//isSpecialAttackUsed = false;
		instance_destroy()
}
