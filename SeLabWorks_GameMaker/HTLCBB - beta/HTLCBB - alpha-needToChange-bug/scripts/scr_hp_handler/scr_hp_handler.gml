
var x_offset = 40;
var y_offset =20;
var width = view_hport[0];
draw_set_font(fnt_bars)


var bar_width = sprite_get_width(spr_bar_frame);
var bar_height = sprite_get_height(spr_bar_frame);


//check if esc pressed


if(p1.hp <=0 && p2.hp >0){
	p1.hp = 0;
	if(room = rm_game){
		global.game1P1point = 0
		global.game1P2point = p2.hp;
	}
	if(room = rm_game2){
		global.game2P1point = 0
		global.game2P2point = p2.hp;
	
	}

	//global.p2point=p2.hp
	//global.p2PointsCount = global.p2PointsCount+p2.hp
	//alarm[0] = room_speed*2
	//if(isTimesUp){
		draw_set_font(fnt_ending)
		draw_text_color(room_width/2-200,room_height/2-100,"Play 2, You Win!",c_red,c_red,c_red,c_red,0.8)
		draw_text_color(room_width/2-300,room_height/2+300,"Press any key to continue",c_red,c_red,c_red,c_red,0.5)
	//}
	isGameOver = true;
	
	if(keyboard_check_pressed(vk_anykey) && isGameOver && room = rm_game){
		room_persistent = false; 
		room_goto(rm_end_to_next_stage)
	}
	if(keyboard_check_pressed(vk_anykey) && isGameOver && room = rm_game2){
		room_persistent = false; 
		room_goto(rm_game_over)
	}
	
	//if(isTimesUp){
	/**var resultInstance = instance_create_layer(room_width,room_height,"instances",obj_game_over_rectangle) 
	with resultInstance{
		draw_text_color(room_width/2,room_height/2,"Play 1, You Win!",c_red,c_red,c_red,c_red,0.5)
		//draw_text()
	}**/
	//}

	exit
	
}
if(p2.hp <=0 && p1.hp>0){
	p2.hp = 0;
	
	//alarm[0] = room_speed*2
	//if(isTimesUp){
	//global.p1PointsCount = global.p1PointsCount+p1.hp
	if(room = rm_game){
		global.game1P1point = p1.hp
		global.game1P2point = 0;
	}
	if(room = rm_game2){
		global.game2P1point = p1.hp
		global.game2P2point = 0;
	
	}
	//global.p1point=p1.hp
	draw_set_font(fnt_ending)
	draw_text_color(room_width/2-200,room_height/2-100,"Play 1, You Win!",c_red,c_red,c_red,c_red,0.8)
	draw_text_color(room_width/2-300,room_height/2+300,"Press any key to continue",c_red,c_red,c_red,c_red,0.5)
	isGameOver = true;
	
	if(keyboard_check_pressed(vk_anykey) && isGameOver && room = rm_game){
		room_persistent = false; 
		room_goto(rm_end_to_next_stage)
	}
	if(keyboard_check_pressed(vk_anykey) && isGameOver && room = rm_game2){
		room_persistent = false; 
		room_goto(rm_game_over)
	}
	
	//}
	//var resultInstance=	instance_create_layer(room_width,room_height,"instances",obj_game_over_rectangle)
	//}
	/**var resultInstance = instance_create_layer(room_width,room_height,"instances",obj_game_over_rectangle) 
	with resultInstance{
		draw_set_font(fnt_ending)
		draw_text_color(room_width/2-250,room_height/2,"Play 2, You Win!",c_red,c_red,c_red,c_red,0.8)
		//draw_text()
	}**/
	
	
exit
	
}


//draw_set_alpha(1)
draw_sprite_ext(spr_bar_frame, 0, x_offset-30,y_offset+120,2,2,0,c_red,1)
draw_sprite_part_ext(spr_bar_back, 1, 0,0,bar_width*(p1.hp/p1.hp_max),bar_height,x_offset-30, y_offset+120,2,2,c_white,1)
draw_text(x_offset+50,y_offset+130,"Player1: "+string(p1.hp));
draw_text(x_offset, y_offset + 160, "You have "+string(p1.specialAttackCounter)+" special attacks!")

draw_sprite_ext(spr_bar_frame, 0, width-x_offset+400,y_offset+120,-2,2,0,c_red,1)
draw_sprite_part_ext(spr_bar_back, 1, 0,0,bar_width*(p2.hp/p2.hp_max),bar_height,width-x_offset+400, y_offset+120,-2,2,c_white,1)
draw_text(width-x_offset+250,y_offset+130,"Player2: "+string(p2.hp));
draw_text(width-x_offset+200, y_offset+160,"You have "+string(p2.specialAttackCounter)+" special attacks!")




