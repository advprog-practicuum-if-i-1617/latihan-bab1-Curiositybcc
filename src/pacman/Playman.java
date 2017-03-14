package pacman;
public class Playman {
    private String map[][] = new String [10][10];
    private void startOver(){
        String map[][] = new String [][]{    {"#","#","#","#","#","#","#","#","#","#"}
                                            ,{"#"," "," "," "," "," "," ","@"," ","#"}
                                            ,{"#","#"," "," "," ","#","#","#","#","#"}
                                            ,{"#","@"," "," "," "," "," "," "," ","#"}
                                            ,{"#","#"," "," "," ","#"," "," ","@","#"}
                                            ,{"#"," "," "," "," ","#","#","#","#","#"}
                                            ,{"#"," "," "," "," "," "," ","#","@","#"}
                                            ,{"#"," "," ","#","#"," "," "," "," ","#"}
                                            ,{"#"," "," ","@","#","#"," "," "," ","#"}
                                            ,{"#","#","#","#","#","#","#","#","#","#"}};
        this.map=map;
    }
    private int posx,posy,score,step;
    private void displayMap(){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        if (score==500){
            System.out.println("You Win");
            score=score+step;
            getStat();
        }
        if (step==0){
            System.out.println("Game Over");
            score=score+step;
            getStat();
        }
    }
    private void pacPosition(int y,int x) {
        this.posx=x;
        this.posy=y;
    }
    public void moveLeft(){
        if (map[posy][posx-1].equals("#")){
            step=step-1;
            map[posy][posx]=">";
        }
        else if (map[posy][posx-1].equals(" ")){
            step=step-1;
            map[posy][posx]=" ";
            map[posy][posx-1]=">";
            pacPosition(posy,posx-1);
        }
        else if (map[posy][posx-1].equals("@")){
            step=step-1;
            map[posy][posx]=" ";
            map[posy][posx-1]=">";
            pacPosition(posy,posx-1);
            score=score+100;
        }
        displayMap();
    }
    public void moveRight(){
        if (map[posy][posx+1].equals("#")){
            step=step-1;
            map[posy][posx]="<";
        }
        else if (map[posy][posx+1].equals(" ")){
            step=step-1;
            map[posy][posx]=" ";
            map[posy][posx+1]="<";
            pacPosition(posy,posx+1);
        }
        else if (map[posy][posx+1].equals("@")){
            step=step-1;
            map[posy][posx]=" ";
            map[posy][posx+1]="<";
            pacPosition(posy,posx+1);
            score=score+100;
        }
        displayMap();
    }
    public void moveDown(){
        if (map[posy+1][posx].equals("#")){
            step=step-1;
            map[posy][posx]="^";
        }
        else if (map[posy+1][posx].equals(" ")){
            step=step-1;
            map[posy][posx]=" ";
            map[posy+1][posx]="^";
            pacPosition(posy+1,posx);
        }
        else if (map[posy+1][posx].equals("@")){
            step=step-1;
            map[posy][posx]=" ";
            map[posy+1][posx]="^";
            pacPosition(posy+1,posx);
            score=score+100;
        }
        displayMap();
    }
    public void moveUp(){
        if (map[posy-1][posx].equals("#")){
            step=step-1;
            map[posy][posx]="v";
        }
        else if (map[posy-1][posx].equals(" ")){
            step=step-1;
            map[posy][posx]=" ";
            map[posy-1][posx]="v";
            pacPosition(posy-1,posx);
        }
        else if (map[posy-1][posx].equals("@")){
            step=step-1;
            map[posy][posx]=" ";
            map[posy-1][posx]="v";
            pacPosition(posy-1,posx);
            score=score+100;
        }
        displayMap();
    }
    public void start(){
        startOver();
        posx=1;
        posy=1;
        map[1][1]="<";
        score=0;
        step=50;
        displayMap();
    }
    public boolean play(){
        if (score<500&&step>0){
            return true;
        }
        else{
            return false;
        }
    }
    public void getStat(){
        System.out.println("Step Left = "+step);
        System.out.println("Score     = "+score);
    }
}