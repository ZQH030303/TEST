package test2;

import java.util.Objects;
import java.util.Scanner;
class Position{
    int hp;
    int ap;
    Position(){
        hp = 0;
        ap = 0;
    }
    boolean live(){
        return hp > 0;
    }
    void set(int h,int a){
        hp = h;
        ap = a;
    }
    void serPosition(Position p){
        hp = p.hp;
        ap = p.ap;
    }
    void battle(Position p){
        hp -= p.ap;
    }
}
class Player{
    int sumNumber = 8;
    int liveRole;
    Position[] positions = new Position[sumNumber];
    Player(){
        for(int i = 0; i < sumNumber; i++){
            positions[i] = new Position();
        }
        liveRole = 0;
    }
    void setHero(){
        positions[0].set(30,0);
    }
    void summon(int p,int a,int h){
        if(liveRole < sumNumber - 1){
            if (positions[p].live()) {
                for (int i = sumNumber - 1; i > p; i--) {
                    positions[i].serPosition(positions[i - 1]);
                }
            }
            positions[p].set(h,a);
            liveRole++;
        }
    }
    void attack(int attacker,int defender,Player opponent){
        positions[attacker].battle(opponent.positions[defender]);

    }
    void sort(int attacker){
        if(positions[attacker].hp <= 0){
            if(attacker > 0){
                for(int i = attacker; i < sumNumber - 1; i++){
                    positions[i].serPosition(positions[i + 1]);
                }
                positions[sumNumber - 1].set(0,0);
                liveRole--;
            }
        }
    }
    boolean heroCondition(){
        return positions[0].live();
    }
    void print(){
        System.out.println(positions[0].hp);
        int sum = 0;
        for(int i = 1; i < sumNumber; i++){
            if(positions[i].live()){
                sum++;
            }
        }
        System.out.print(sum);
        if(sum > 0){
            System.out.print(" ");
            for(int i = 1; i < sumNumber; i++){
                if(positions[i].live()){
                    System.out.print(positions[i].hp);
                    if(i != sum){
                        System.out.print(" ");
                    }
                }
            }
        }
        System.out.println();
    }
}
/** @author 朱启煌 */
public class Experiment2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int turn = 1;
        Player p1 = new Player();
        p1.setHero();
        Player p2 = new Player();
        p2.setHero();
        while(n-- > 0){
            String order = sc.next();
            if(Objects.equals(order, "summon")){
                int position,attack,health;
                position = sc.nextInt();
                attack = sc.nextInt();
                health = sc.nextInt();
                if(turn == 1){
                    p1.summon(position,attack,health);
                }
                else{
                    p2.summon(position,attack,health);
                }
            }
            else if(Objects.equals(order, "attack")){
                int attacker,defender;
                attacker = sc.nextInt();
                defender = sc.nextInt();
                if(turn == 1){
                    p1.attack(attacker,defender,p2);
                    p2.attack(defender,attacker,p1);
                    p1.sort(attacker);
                    p2.sort(defender);
                }
                else{
                    p2.attack(attacker,defender,p1);
                    p1.attack(defender,attacker,p2);
                    p2.sort(attacker);
                    p1.sort(defender);
                }
            }
            else if(Objects.equals(order, "end")){
                if(turn == 1){
                    turn = 2;
                }
                else{
                    turn = 1;
                }
            }
            if(!p1.heroCondition() || !p2.heroCondition()){
                break;
            }
        }
        if(p1.heroCondition() && p2.heroCondition()){
            System.out.println("0");
            p1.print();
            p2.print();
        }
        else if(p1.heroCondition() && !p2.heroCondition()){
            System.out.println("1");
            p1.print();
            p2.print();
        }
        else if(!p1.heroCondition() && p2.heroCondition()){
            System.out.println("-1");
            p1.print();
            p2.print();
        }
    }
}
