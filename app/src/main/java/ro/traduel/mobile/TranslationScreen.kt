package ro.traduel.mobile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TranslationScreen() {
    var text by rememberSaveable { mutableStateOf("") }
    var sourceLanguage by rememberSaveable { mutableStateOf("Română") }
    var targetLanguage by rememberSaveable { mutableStateOf("Engleză") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .imePadding()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("Traduel", style = MaterialTheme.typography.headlineLarge)
        Text("Compară traduceri și alege varianta potrivită pentru tine.")

        LanguageSelector("Limba sursă", sourceLanguage, targetLanguage) {
            sourceLanguage = it
        }
        LanguageSelector("Limba țintă", targetLanguage, sourceLanguage) {
            targetLanguage = it
        }
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Text de tradus") },
            placeholder = { Text("Introdu textul aici…") },
            minLines = 5,
            supportingText = { Text("${text.length} caractere") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TranslationScreenPreview() {
    MaterialTheme {
        TranslationScreen()
    }
}
