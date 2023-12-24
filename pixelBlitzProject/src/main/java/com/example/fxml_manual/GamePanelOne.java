package com.example.fxml_manual;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanelOne extends javax.swing.JPanel implements ActionListener {
    PlayerOne player;
    int cameraX;
    ArrayList<Wall>walls = new ArrayList<>();
    Timer gameTimer;
    int offset;

    public GamePanelOne(){

        player = new PlayerOne(400,300,this);

        reset();

//        makeWalls(50);

        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {

            @Override
            public void run() {

                if(walls.get(walls.size()-1).x<800){
                    offset+=700;
                    System.out.println("Size of wall"+ walls.size());
                    makeWalls(offset);

                }

                player.set();
                for (Wall wall:walls) wall.set(cameraX);

                for(int i =0;i< walls.size();i++){
                    if(walls.get(i).x<-800)walls.remove(i);
                }

                repaint();

            }
        },0,17);

    }
    public void reset(){
        player.x=200;
        player.y=150;
        cameraX=150;
        player.x_speed=0;
        player.y_speed=0;
        offset = -150;
        makeWalls(offset);
    }
    public void makeWalls(int offset){
        int s=50;
        Random rand = new Random();
        int index=rand.nextInt(4);
        if(index == 0){
            for(int i=0;i<14;i++)walls.add(new Wall(Color.PINK,offset+i*50,600,s,s));
        }
        else if(index == 1){
            for(int i=0;i<5;i++)walls.add(new Wall(Color.WHITE,offset+i*50,600,s,s));
            walls.add(new Wall(Color.WHITE,offset+500,600,s,s));
            walls.add(new Wall(Color.WHITE,offset+550,600,s,s));
            walls.add(new Wall(Color.WHITE,offset+600,600,s,s));
            walls.add(new Wall(Color.WHITE,offset+650,600,s,s));
            walls.add(new Wall(Color.WHITE,offset+700,600,s,s));
            walls.add(new Wall(Color.WHITE,offset+750,600,s,s));

        }
        else if(index==2){
            for(int i=0;i<14;i++)walls.add(new Wall(Color.GREEN,offset+i*50,600,s,s));
            for(int i=0;i<12;i++)walls.add(new Wall(Color.GREEN,offset+50+i*50,550,s,s));
            for(int i=0;i<10;i++)walls.add(new Wall(Color.GREEN,offset+100+i*50,500,s,s));
            for(int i=0;i<10;i++)walls.add(new Wall(Color.GREEN,offset+150+i*50,450,s,s));
            for(int i=0;i<10;i++)walls.add(new Wall(Color.GREEN,offset+200+i*50,400,s,s));


        }
        else {
            for(int i=0;i<3;i++)walls.add(new Wall(Color.BLUE,offset+i*50,600,s,s));
            for(int i=0;i<2;i++)walls.add(new Wall(Color.BLUE,offset+50+i*50,550,s,s));
            walls.add(new Wall(Color.WHITE,offset+450,500,s,s));
            walls.add(new Wall(Color.WHITE,offset+300,500,s,s));
            walls.add(new Wall(Color.WHITE,offset+550,500,s,s));

        }

    }
    public void paint(Graphics g){
        super.paint(g);

        Graphics2D gtd = (Graphics2D) g;

        player.draw(gtd);

        for(Wall wall:walls)wall.draw((gtd));

    }
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()=='a') player.KeyLeft = true;
        if(e.getKeyChar()=='w') player.KeyUp = true;
        if(e.getKeyChar()=='s') player.KeyDown = true;
        if(e.getKeyChar()=='d') player.KeyRight = true;
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar()=='a') player.KeyLeft = false;
        if(e.getKeyChar()=='w') player.KeyUp = false;
        if(e.getKeyChar()=='s') player.KeyDown = false;
        if(e.getKeyChar()=='d') player.KeyRight = false;
    }
    @Override
    public void actionPerformed(ActionEvent ae){

    }
}
