package com.example.mpeiguide.info.organizations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mpeiguide.R;

public class OrganizationDetailsActivity extends AppCompatActivity {

    private ImageView avatar;
    private TextView name;
    private TextView vkName;
    private TextView president;
    private TextView place;
    private TextView description;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_details);

        avatar = findViewById(R.id.org_details_avatar);
        name = findViewById(R.id.org_details_name);
        vkName = findViewById(R.id.org_details_vk_name);
        president = findViewById(R.id.org_details_president);
        place = findViewById(R.id.org_details_place);
        description = findViewById(R.id.org_details_description);

        back = findViewById(R.id.org_details_back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        final Intent intent = getIntent();

        if(intent.getIntExtra(Organization.IMAGE_ID,Organization.NONE) != Organization.NONE) {
            avatar.setImageResource(intent.getIntExtra(Organization.IMAGE_ID, Organization.NONE));
        }
        name.setText(intent.getStringExtra(Organization.NAME));
        vkName.append(intent.getStringExtra(Organization.VK_NAME));
        president.append(intent.getStringExtra(Organization.PRESIDENT));
        place.append(intent.getStringExtra(Organization.PLACE));
        description.setText(intent.getStringExtra(Organization.DESCRIPTION));

        vkName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent goToVk = new Intent(Intent.ACTION_VIEW, Uri.parse(intent.getStringExtra(Organization.VK_LINK)));
                    startActivity(goToVk);
                }catch (Exception e){

                }
            }
        });
    }
}