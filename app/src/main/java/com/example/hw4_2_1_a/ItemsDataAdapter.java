package com.example.hw4_2_1_a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemsDataAdapter extends BaseAdapter {
    // Хранит список всех элементов списка
    private List<ItemData> items;
    // LayoutInflater – класс, который из layout-файла создает View-элемент.
    private LayoutInflater inflater;

    // Конструктор, в который передается контекст для создания контролов из XML. И первоначальный список элементов.
    ItemsDataAdapter(Context context, List<ItemData> items) {
        if (items == null) {
            this.items = new ArrayList<>();
        } else {
            this.items = items;
        }
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // Слушает все изменения галочки и меняет состояние конкретного ItemData
    private CompoundButton.OnCheckedChangeListener myCheckChangeList
            = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            items.get((Integer) buttonView.getTag()).setChecked(isChecked);
        }
    };

    // Добавляет элемент в конец списка. notifyDataSetChanged сообщает об обновлении данных и переотрисовывает.
    void addItem(ItemData item) {
        this.items.add(item);
        notifyDataSetChanged();
    }

    // Обязательный метод абстрактного класса BaseAdapter. Он возвращает колличество элементов списка.
    @Override
    public int getCount() {
        return items.size();
    }

    // Тоже обязательный метод. Должен возвращать элемент списка на позиции - position
    @Override
    public ItemData getItem(int position) {
        if (position < items.size()) {
            return items.get(position);
        } else {
            return null;
        }
    }

    // И это тоже обязательный метод. Возвращает идентификатор. Обычно это position.
    @Override
    public long getItemId(int position) {
        return position;
    }

    // Создает или возвращает переиспользуемый View, с новыми данными для конкретной позиции.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.item_list_view, parent, false);
        }

        ItemData itemData = items.get(position);

        ImageView image = view.findViewById(R.id.icon);
        TextView title = view.findViewById(R.id.title);
        TextView subtitle = view.findViewById(R.id.subtitle);
        CheckBox checkBox = view.findViewById(R.id.checkbox);

        image.setImageResource(itemData.getImageId());
        title.setText(itemData.getTitle());
        subtitle.setText(itemData.getSubtitle());
        checkBox.setOnCheckedChangeListener(myCheckChangeList);
        checkBox.setTag(position);
        checkBox.setChecked(itemData.isChecked());

        return view;
    }
}