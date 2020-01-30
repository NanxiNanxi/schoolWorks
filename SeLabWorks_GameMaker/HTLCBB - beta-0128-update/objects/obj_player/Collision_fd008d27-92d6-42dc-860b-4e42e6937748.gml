/// @description Insert description here
// You can write your code in this editor
if(!isCrouchBlocking){
		if other.owner == self
	{
		audio_play_sound(bgm_punch,1000, false)
		
		exit
	}


	hit = 1;
	audio_play_sound(bgm_pain_short,1000, false)
	hp -= other.damage;
}
	alarm[5] = room_speed/3
	with other 
		instance_destroy()


