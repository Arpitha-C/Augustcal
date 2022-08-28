package com.example.augustcal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void checkForPowerOf()
    {
        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        for(int i = 0; i < workings.length(); i++)
        {
            if (workings.charAt(i) == '^')
                indexOfPowers.add(i);
        }
        formula = workings;
        tempFormula = workings;
        for(Integer index: indexOfPowers)
        {
            changeFormula(index);
        }
        formula = tempFormula;
    }
    private void changeFormula(Integer index)
    {
        String numberLeft = "";
        String numberRight = "";
        for(int i = index + 1; i< workings.length(); i++)
        {
            if(isNumeric(workings.charAt(i)))
                numberRight = numberRight + workings.charAt(i);
            else
                break;
        }
        for(int i = index - 1; i >= 0; i--)
        {
            if(isNumeric(workings.charAt(i)))
                numberLeft = numberLeft + workings.charAt(i);
            else
                break;
        }
        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow("+numberLeft+","+numberRight+")";
        tempFormula = tempFormula.replace(original,changed);
    }
    private boolean isNumeric(char c)
    {
        if((c <='9' && c >='0' || c=='.'))
        {
            return true;
        }
        else
            return false;
    }
