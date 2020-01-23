/// @description Insert description here
// You can write your code in this editor
//global.p1PointsCount = global.game1P1point + global.game2P1point
//global.p2PointsCount = global.game1P2point + global.game2P2point
draw_set_font(fnt_ending)
draw_set_color(c_white)
draw_text(room_width/2-130,50,"GAME OVER")
//draw_text(room_width/2-150,room_height/2-200,"p1 points: "+string(global.p1PointsCount))
//draw_text(room_width/2-150,room_height/2-150,"p2 points: "+string(global.p2PointsCount))

var width = room_width/2;
draw_set_font(fnt_MenuItems);
draw_set_halign(fa_center);

for(var i =0; i < array_length_1d(menu);i++){
	draw_set_color(i==current_index?c_red:c_white);
	draw_text(width, 360+60*i, menu[i]);
}
draw_set_color(c_white);
draw_set_halign(fa_left);

if max(keyboard_check_pressed(ord("W")), 0 ,keyboard_check_pressed(vk_up))==1{
	current_index--;
	if current_index <0 current_index = array_length_1d(menu)-1
}

if  max(keyboard_check_pressed(ord("S")), 0 ,keyboard_check_pressed(vk_down))==1{
	current_index++;
	if current_index > array_length_1d(menu)-1 current_index = 0;
}



if keyboard_check_pressed(vk_enter){
	switch (current_index){
		case 0:
			room_goto(rm_choose_stage);
			break
			
		case 1:
			room_goto(rm_main_menu);
		break;
		
		case 2:
			game_end()
		break
		
		break
		
		
	}
}

