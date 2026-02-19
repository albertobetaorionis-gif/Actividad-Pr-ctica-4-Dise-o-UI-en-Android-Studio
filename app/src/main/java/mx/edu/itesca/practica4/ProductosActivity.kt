package mx.edu.itesca.practica4

import android.content.Context
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class ProductosActivity : AppCompatActivity() {

    var menu: ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        // 🔹 Obtener el tipo de menú enviado desde MenuActivity
        val menuOption: String? = intent.getStringExtra("menuType")

        // 🔹 CAMBIAR TITULO
        supportActionBar?.title = menuOption

        // 🔹 CAMBIAR IMAGEN SUPERIOR
        val imagen : ImageView = findViewById<ImageView>(R.id.imagenView)
        when(menuOption){
            "Antojitos" -> imagen.setImageResource(R.drawable.antojitos)
            "Especialidades" -> imagen.setImageResource(R.drawable.especialidades)
            "Combinations" -> imagen.setImageResource(R.drawable.combinations)
            "Tortas" -> imagen.setImageResource(R.drawable.tortas)
            "Sopas" -> imagen.setImageResource(R.drawable.sopas)
            "Drinks" -> imagen.setImageResource(R.drawable.drinks)
        }

        // 🔹 Cargar productos
        agregarProductos(menuOption)

        // 🔹 Mostrar lista
        val listView: ListView = findViewById(R.id.listView)
        val adaptador: AdaptadorProductos = AdaptadorProductos(this, menu)
        listView.adapter = adaptador
    }

    fun agregarProductos(option:String?){
        when(option){
            "Antojitos"->{
                menu.add(Product("Quesadillas", R.drawable.quesadillas,
                    "Rellenas con su carne favorita, servidas con ensalada. Filled with your choice of meat, served with salad.",
                    6.29))
                menu.add(Product("Huaraches", R.drawable.huaraches,
                    "Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema - Big thick tortilla with beans, your choice of meat, fresh cheese and cream.",
                    11.49))
                menu.add(Product( "Gringas", R.drawable.gringas,
                    "Tortilla de harina con queso, carne al pastor y piña Flour tortilla with cheese marinated pork and pineapple.",
                    8.39))
                menu.add(Product("Sincronizadas", R.drawable.sincronizadas,
                    "Tortilla de harina rellena con queso y jamón. Acompañada de lechuga, crema y guacamole. Two flour tortillas filled with ham and cheese. Served with lettuce, cream, and guacamole.",
                    7.99))
                menu.add(Product("Sopes", R.drawable.sopes,
                    "Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema. Fried thick tortilla with beans, your choice of meat, lettuce, fresh cheese and cream.",
                    3.99))
                menu.add(Product("Tostadas", R.drawable.tostadas,
                    "Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate. Fried tortilla with beans, your choice of meat, lettuce, fresh cheese, cream and tomato.",
                    4.59))
            }
            "Especialidades"->{
                menu.add(Product("Mojarra Frita", R.drawable.mojarra,
                    "Tilapia frita servida con lechuga, cebolla, jitomate, aguacate y tortillas. Fried tilapia served with lettuce, onions, tomatoes, avocado and tortillas.",
                    17.99))
                menu.add(Product("Ceviche", R.drawable.ceviche,
                    "Tilapia, camarones, aguacate y pico de gallo servido con chips. Tilapia, shrimp, avocado and pico de gallo, served with chips.",
                    6.99))
                menu.add(Product("Botana De Camarones Al Mojo De Ajo", R.drawable.botanacamarones,
                    "",
                    19.99))
            }
            "Combinations"->{
                menu.add(Product("Traditional Taco Combo", R.drawable.taco,
                    "Tortilla de maíz y tu carne favorita. Servido con arroz y frijoles. Corn taco, your choice of meat, served with rice and beans.",
                    6.99))
                menu.add(Product("Mexican Burritos", R.drawable.burritos,
                    "Tu carne favorita en una tortilla grande de harina rellena con cebolla frita, pico de gallo, sour cream, frijoles y acompañado de arroz. Your favorite meat in a large flour tortilla filled with fried onions, pico de gallo, sour cream, beans and served with rice.",
                    13.69))
                menu.add(Product("Los Portales Burritos", R.drawable.burritosportales,
                    "Tortilla de harina grande rellena de nopal asado, bistec, pastor, cebollas asadas, arroz y frijoles, servida con una guarnición de ensalada de lechuga. Large flour tortilla filled with grilled cactus, steak, pastor (seasoned pork), grilled onions, rice and beans, served with a side of lettuce salad.",
                    6.99))
                menu.add(Product("Cinco", R.drawable.cinco,
                    "Un taco de venta fuerte con su elección de carne, lechuga y queso. Un burrito con su elección de carne, pico de gallo, crema agria y frijoles. Servido con arroz y frijoles. One hard sell taco with your choice of meat, lettuce and cheese. One burrito with your choice of meat, pico de gallo, sour cream, and beans. Served with rice and beans.",
                    6.99))
                menu.add(Product("Dos Amigos", R.drawable.dosamigos,
                    "Dos tacos de tortilla dura con la carne de su elección cubiertos con lechuga y queso rallado, servidos con un arroz y frijoles. Two hard shell tacos with your choice of meat topped with lettuce and shredded cheese, served with a side of rice and beans.",
                    10.99))
            }
            "Tortas"->{
                menu.add(Product("Torta Regular", R.drawable.torta,
                    "Todas las tortas vienen con lechuga, cebolla, tomate, aguacate, crema agria, chile jalapeño y la carne de su elección. All tortas come with lettuce, onions, tomatoes, avocado, sour cream, jalapeno pepper and your choice of meat.",
                    13.39))
                menu.add(Product("Torta - Milanesa de Res o Pollo", R.drawable.tortamilanesa,
                    "",
                    13.69))
                menu.add(Product("Torta Cubana", R.drawable.tortacubana,
                    "Chorizo, asada, jamon, pastor y queso. Mexican sausage, steak, marinated pork, ham, and cheese.",
                    14.99))
                menu.add(Product("Torta Mixta", R.drawable.tortamixta,
                    "Chorizo, asada y pastor. Mexican sausage, steak and marinated pork.",
                    13.99))
                menu.add(Product("Small Mexican Torta", R.drawable.smallmexican,
                    "Sándwich de pan bolillo con tu de carne, lechuga rallada, aguacate, tomate, cebolla y crema agria. Bolillo bread sandwich with your of meat, shredded lettuce, avocado, tomato, onion and sour cream.",
                    11.99))
            }
            "Sopas"->{
                menu.add(Product("Pozole", R.drawable.pozole,
                    "MIÉRCOLES - DOMINGO: Costillas de cerdo y estofado con maíz y orégano. ¡NO OLVIDEN NUESTRA BARRA DE SALSAS PARA AÑADIRLE MÁS SABOR!WEDNSDAY - SUNDAY Pork ribs and bonston butt stew with homminy and oregano. DO NOT FORGET OUR SALSA BAR TO MAKE IT MORE FLAVORFULL.",
                    7.99))
                menu.add(Product("Menudo", R.drawable.menudo,
                    "MENUDO Caldo ancestral, callos sedosos, se unen en un plato que sabe a mañanas de domingo, a cocinas familiares y a historias transmitidas de generación en generación. MENUDO Ancestral broth, silky tripe, come together in a bowl that tastes like Sunday mornings, family kitchens, and stories passed down,",
                    7.99))
                menu.add(Product("Caldo de Res", R.drawable.caldores,
                    "Costillas de res y guiso con maíz, papa, chayote, repollo, cilantro, cebolla, calabacín, zanahorias, limón y tortillas. Beef ribs and chuck stew with corn, potato, chayote (squash family), cabage, cilantro, onion, zuccini, carrots, lime, and tortillas. ",
                    5.99))
                menu.add(Product("Caldo de Camarón", R.drawable.caldocamaron,
                    "Sopa de Camarón. Shrimp soup.",
                    13.99))
                menu.add(Product("Sopa de Mariscos", R.drawable.sopamariscos,
                    "Sopa de Mariscos. Seafood soup.",
                    21.99))
            }
            "Drinks"->{
                menu.add(Product("Michelada", R.drawable.michelada,
                    "",
                    3.75))
                menu.add(Product("Jarritos", R.drawable.jarritos,
                    "",
                    5.75))
                menu.add(Product("Caguama", R.drawable.caguama,
                    "",
                    5.75))
                menu.add(Product("Caguamas Micheladas", R.drawable.caguamamichelada,
                    "",
                    2.75))
                menu.add(Product("Charolazo", R.drawable.charolazo,
                    "",
                    9.75))
                menu.add(Product("Cubeta Siz", R.drawable.cubetasix,
                    "",
                    9.75))
                menu.add(Product("Cubetazo", R.drawable.cubetazo,
                    "",
                    9.75))
                menu.add(Product("Mexican Beer", R.drawable.mexicanbeer,
                    "",
                    2.75))
                menu.add(Product("Sodas", R.drawable.sodas,
                    "",
                    2.75))
            }
        }
    }

    private class AdaptadorProductos: BaseAdapter {
        var producto=ArrayList<Product>()
        var contexto: Context? = null

        constructor(contexto: Context, producto: ArrayList<Product>){
            this.producto=producto
            this.contexto=contexto
        }

        override fun getCount(): Int {
            return producto.size
        }

        override fun getItem(position: Int): Any {
            return producto[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
            val prod = producto[position]
            val inflador = LayoutInflater.from(contexto)
            val vista = inflador.inflate(R.layout.producto_view, null)

            val imagen = vista.findViewById<ImageView>(R.id.producto_img)
            val nombre = vista.findViewById<TextView>(R.id.producto_nombre)
            val desc = vista.findViewById<TextView>(R.id.producto_desc)
            val precio = vista.findViewById<TextView>(R.id.producto_precio)

            imagen.setImageResource(prod.image)
            nombre.text = prod.name
            desc.text = prod.description
            precio.text = "$${prod.price}"

            return vista
        }
    }
}
