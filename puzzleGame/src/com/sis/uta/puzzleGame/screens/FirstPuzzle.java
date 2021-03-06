package com.sis.uta.puzzleGame.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class FirstPuzzle implements Screen{
	
	private Game game;
	
	public FirstPuzzle(Game game) {
		this.game = game;
	}

	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton buttonBack, buttonCheck;
	private BitmapFont white, black;
	private Label heading;
	private TextField a11, a12, a13, a21, a22, a23, a31, a32, a33;
	int i11,i12,i13,i21,i22,i23,i31,i32,i33;

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		
		stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		
		stage=new Stage();
		Gdx.input.setInputProcessor(stage);
		
		atlas=new TextureAtlas("ui/button.pack");
		//Skin skin = new Skin(Gdx.files.internal("data/packfp.json"));
		skin=new Skin(atlas);
		
		table=new Table(skin);
		
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		white=new BitmapFont(Gdx.files.internal("font/white.fnt"), false);
		black=new BitmapFont(Gdx.files.internal("font/black.fnt"), false);
		
		TextButtonStyle textButtonStyle=new TextButtonStyle();
		textButtonStyle.up=skin.getDrawable("button.up");
		textButtonStyle.down=skin.getDrawable("button.down");
		textButtonStyle.pressedOffsetX=1;
		textButtonStyle.pressedOffsetY=-1;
		textButtonStyle.font=black;
		
		TextFieldStyle textFieldStyle= new TextFieldStyle();
		textFieldStyle.fontColor = Color.WHITE;
		textFieldStyle.focusedFontColor = Color.PINK;
		textFieldStyle.background = skin.getDrawable("button.up");
		textFieldStyle.font = black;
		
		a11 = new TextField("2", textFieldStyle);
		a12 = new TextField("9", textFieldStyle);
		a13 = new TextField("4", textFieldStyle);
		a21 = new TextField("7", textFieldStyle);
		a22 = new TextField("5", textFieldStyle);
		a23 = new TextField("3", textFieldStyle);
		a31 = new TextField("6", textFieldStyle);
		a32 = new TextField("1", textFieldStyle);
		a33 = new TextField("8", textFieldStyle);
		
		
		buttonCheck=new TextButton("Check", textButtonStyle);
		buttonCheck.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
								
				//check the result
				
				boolean correctanswer;
				correctanswer = true;
				
				//1. textfields are not empty
				if(a11==null || a12==null || a13==null || a21==null || a22==null || a23==null || a31==null || a32==null || a33==null
						|| a11.getText().length()==0 || a12.getText().length()==0 || a13.getText().length()==0
						|| a21.getText().length()==0 || a22.getText().length()==0 || a23.getText().length()==0
						|| a31.getText().length()==0 || a32.getText().length()==0 || a33.getText().length()==0) {
					correctanswer = false;
				}
				
				//2. input = 1..9
				if(correctanswer) {
					if(!(a11.getText().charAt(0) >= 49 && a11.getText().charAt(0) <= 57
							&& a12.getText().charAt(0) >= 49 && a12.getText().charAt(0) <= 57
							&& a13.getText().charAt(0) >= 49 && a13.getText().charAt(0) <= 57
							&& a21.getText().charAt(0) >= 49 && a21.getText().charAt(0) <= 57
							&& a22.getText().charAt(0) >= 49 && a22.getText().charAt(0) <= 57
							&& a23.getText().charAt(0) >= 49 && a23.getText().charAt(0) <= 57
							&& a31.getText().charAt(0) >= 49 && a31.getText().charAt(0) <= 57
							&& a32.getText().charAt(0) >= 49 && a32.getText().charAt(0) <= 57
							&& a33.getText().charAt(0) >= 49 && a33.getText().charAt(0) <= 57)){
						correctanswer = false;
					}	
				}
				
				//3. only numbers admitted
				if(correctanswer){
					try {
						i11 = Integer.parseInt(a11.getText());
						i12 = Integer.parseInt(a12.getText());
						i13 = Integer.parseInt(a13.getText());
						i21 = Integer.parseInt(a21.getText());
						i22 = Integer.parseInt(a22.getText());
						i23 = Integer.parseInt(a23.getText());
						i31 = Integer.parseInt(a31.getText());
						i32 = Integer.parseInt(a32.getText());
						i33 = Integer.parseInt(a33.getText());
					}
					catch (NumberFormatException e) {
						correctanswer = false;
					}
				
					//3.1. sums = 15
					if(correctanswer) {
						if(!(i11+i12+i13 == 15 && i21+i22+i23 == 15 && i31+i32+i33 == 15
								&& i11+i21+i31 == 15 && i12+i22+i32 == 15 && i13+i23+i33 == 15
								&& i11+i22+i33 == 15 && i13+i22+i31 == 15)){
									correctanswer = false;
						}	
					}
				
					//3.2 numbers are different
					if(correctanswer){
						if(i11 == i12 || i11 == i13 || i11 == i21 || i11 == i22 || i11 == i23
							|| i11 == i31 || i11 == i32 || i11 == i33 || i12 == i13 || i12 == i21
							|| i12 == i22 || i12 == i23 || i12 == i31 || i12 == i32 || i12 == i33
							|| i13 == i21 || i13 == i22 || i13 == i23 || i13 == i31 || i13 == i32
							|| i13 == i33 || i21 == i22 || i21 == i23 || i21 == i31 || i21 == i32
							|| i21 == i33 || i22 == i23 || i22 == i31 || i22 == i32 || i22 == i33
							|| i23 == i31 || i23 == i32 || i23 == i33 || i31 == i32 || i31 == i33
							|| i32 == i33){
							correctanswer = false;
						} 
					}
				}
				
				
				if(correctanswer) {
					((Game)Gdx.app.getApplicationListener()).setScreen(new FirstSection(game));
				}
				else
				{
					a11.setText("");
					a12.setText("");
					a13.setText("");
					a21.setText("");
					a22.setText("");
					a23.setText("");
					a31.setText("");
					a32.setText("");
					a33.setText("");
					
				}
			}
		});
		
		buttonBack=new TextButton("Back", textButtonStyle);
		buttonBack.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				((Game)Gdx.app.getApplicationListener()).setScreen(new SectionSelect(game));
			}
		});
		
		LabelStyle headingStyle=new LabelStyle(white, Color.WHITE);
		
		
		heading=new Label("Use once every number from 1 to 9 to fill the table.\n " +
				"The sum of numbers in each row, each column\n" +
				" and each diagonal must be equal to 15.", headingStyle);
		heading.setFontScale(0.6f);
		heading.setWrap(true);
		heading.setColor(Color.WHITE);
		
		table.add(heading);
		table.row();
		table.add(a11).maxWidth(Gdx.graphics.getWidth()/6).maxHeight(Gdx.graphics.getHeight()/9);
		table.add(a12).maxWidth(Gdx.graphics.getWidth()/6).maxHeight(Gdx.graphics.getHeight()/9);
		table.add(a13).maxWidth(Gdx.graphics.getWidth()/6).maxHeight(Gdx.graphics.getHeight()/9);
		table.row();
		table.add(a21).maxWidth(Gdx.graphics.getWidth()/6).maxHeight(Gdx.graphics.getHeight()/9);
		table.add(a22).maxWidth(Gdx.graphics.getWidth()/6).maxHeight(Gdx.graphics.getHeight()/9);
		table.add(a23).maxWidth(Gdx.graphics.getWidth()/6).maxHeight(Gdx.graphics.getHeight()/9);
		table.row();
		table.add(a31).maxWidth(Gdx.graphics.getWidth()/6).maxHeight(Gdx.graphics.getHeight()/9);
		table.add(a32).maxWidth(Gdx.graphics.getWidth()/6).maxHeight(Gdx.graphics.getHeight()/9);
		table.add(a33).maxWidth(Gdx.graphics.getWidth()/6).maxHeight(Gdx.graphics.getHeight()/9);
		table.row();
		table.add(buttonCheck).minWidth(Gdx.graphics.getWidth()/4).minHeight(Gdx.graphics.getHeight()/9).row();
		table.add(buttonBack).minWidth(Gdx.graphics.getWidth()/4).minHeight(Gdx.graphics.getHeight()/9).row();
		
		stage.addActor(table);
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}

