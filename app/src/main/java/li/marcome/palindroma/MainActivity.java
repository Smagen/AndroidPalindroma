package li.marcome.palindroma;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    String parolaContraria, parolaInserita;
    int i;
    EditText testo;
    Button pulsante;
    TextView risultato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parolaContraria = parolaInserita = "";
        i = 0;
        testo = (EditText) findViewById(R.id.parola);
        pulsante = (Button) findViewById(R.id.button);

        pulsante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager ime = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                ime.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                //queste due righe fanno chiudere la tastiera dopo la pressione del pulsante

                risultato = (TextView) findViewById(R.id.risposta);

                parolaInserita = testo.getText().toString().toLowerCase().trim();
                //prendo la parola dalla edittext, la faccio diventare in minuscolo e tolgo gli eventuali spazi prima e dopo

                parolaContraria = new StringBuilder(parolaInserita).reverse().toString();
                //inverto la parola inserita

                if (parolaInserita.contentEquals("")) {
                    risultato.setText("Non hai inserito alcuna parola!");
                    risultato.setTextColor(Color.BLUE);
                }
                else {
                    if (parolaInserita.contentEquals(parolaContraria)) {
                        risultato.setText("Sì, la parola è palindroma!");
                        risultato.setTextColor(Color.GREEN);
                    }
                    else {
                        risultato.setText("No, la parola non è palindroma!");
                        risultato.setTextColor(Color.RED);
                    }
                }
                //confronto le due parole e stampo l'outpout sulla textview "risultato"
            }
        });
    }
}